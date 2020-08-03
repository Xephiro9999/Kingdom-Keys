package online.kingdomkeys.kingdomkeys.item.organization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import online.kingdomkeys.kingdomkeys.KingdomKeys;

public class OrganizationDataLoader {

    //GSON builder with custom deserializer for keyblade data
    public static final Gson GSON_BUILDER = new GsonBuilder().registerTypeAdapter(OrganizationData.class, new OrganizationDataDeserializer()).setPrettyPrinting().create();

    /**
     * Method searches the keyblades folder in the datapack for all json files inside it.
     * Loaded data is assigned to the keyblade with the same name as the json file
     * @param manager Resource manager from the server
     */
    
    public static List<String> names = new LinkedList<String>();
    public static List<String> dataList = new LinkedList<String>();

    public static void loadData(IResourceManager manager) {
        String folder = "organization";
        String extension = ".json";
        
        for (ResourceLocation file : manager.getAllResourceLocations(folder, n -> n.endsWith(extension))) { //Get all .json files
            ResourceLocation organizationDataID = new ResourceLocation(file.getNamespace(), file.getPath().substring(folder.length() + 1, file.getPath().length() - extension.length()));
          //  KingdomKeys.LOGGER.info("Found keyblade data file {}, ID {}", file, keybladeDataID);
            IOrgWeapon weapon = (IOrgWeapon) ForgeRegistries.ITEMS.getValue(organizationDataID);
            try {
            	BufferedReader br = new BufferedReader(new InputStreamReader(manager.getResource(file).getInputStream()));
            	BufferedReader br2 = new BufferedReader(new InputStreamReader(manager.getResource(file).getInputStream()));
            	//System.out.println(organizationDataID+": "+manager.getResource(file));
            	String data = "";
            	while(br.ready()) {
            		data += br.readLine();
            	}
            	dataList.add(data);
            	OrganizationData result;
                try {
                    result = GSON_BUILDER.fromJson(br2, OrganizationData.class);
                    names.add(organizationDataID.toString());
                   
                } catch (JsonParseException e) {
                    KingdomKeys.LOGGER.error("Error parsing json file {}: {}", manager.getResource(file).getLocation().toString(), e);
                    continue;
                }
                weapon.setOrganizationData(result);
                IOUtils.closeQuietly(manager.getResource(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
