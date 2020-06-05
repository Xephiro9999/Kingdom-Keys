package online.kingdomkeys.kingdomkeys.client.gui.menu;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.lib.Strings;
import online.kingdomkeys.kingdomkeys.lib.Utils;

public class GuiMenu_Background extends Screen {

	public GuiMenu_Background(String name) {
		super(new TranslationTextComponent(name));
		minecraft = Minecraft.getInstance();
	}

	public boolean drawPlayerInfo;

	GuiElementBar bottomLeftBar, bottomRightBar, topLeftBar, topRightBar;

	float topBarHeight;
	float bottomBarHeight;
	float topLeftBarWidth;
	float topRightBarWidth;
	float topGap;
	float bottomLeftBarWidth;
	float bottomRightBarWidth;
	float bottomGap;
	float middleHeight;

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		drawBars();
		drawMunnyTime();
		drawBiomeDim();
		//RenderHelper.disableStandardItemLighting();
		drawBackground(width, height, drawPlayerInfo);
		super.render(mouseX, mouseY, partialTicks);
	}

	public void drawBars() {
		renderBackground();
		int sh = Minecraft.getInstance().getMainWindow().getScaledHeight();
		int sw = Minecraft.getInstance().getMainWindow().getScaledWidth();

		for (int i = 0; i < sh; i += 3) {
			GL11.glPushMatrix();
			RenderSystem.color3f(1, 1, 1);
			// RenderSystem.enableAlpha();
			RenderSystem.enableBlend();
			minecraft.textureManager.bindTexture(menu);
			RenderSystem.translatef(0, i, 0);
			RenderSystem.scalef(sw, 1, 1);
			blit(0, 0, 77, 92, 1, 1);
			GL11.glPopMatrix();
		}
		topLeftBar.draw();
		topRightBar.draw();
		bottomLeftBar.draw();
		bottomRightBar.draw();
	}

	public void drawBiomeDim() {
		RenderSystem.pushMatrix();
		{
			String text = minecraft.player.dimension.getRegistryName().getPath().toUpperCase() + " | " + minecraft.player.world.getBiome(minecraft.player.getPosition()).getDisplayName().getFormattedText();
			drawString(minecraft.fontRenderer, text, width - minecraft.fontRenderer.getStringWidth(text) - 5, 5, 0xF58B33);

			minecraft.textureManager.bindTexture(new ResourceLocation(KingdomKeys.MODID, "textures/gui/menu/mouse_icons.png"));
			RenderSystem.color4f(1, 1, 1, 1);
			text = "Accept";
			blit(width - minecraft.fontRenderer.getStringWidth(text) - 80, 19, 0, 35, 15, 20);
			drawString(minecraft.fontRenderer, text, width - minecraft.fontRenderer.getStringWidth(text) - 60, 25, 0xF58B33);

			minecraft.textureManager.bindTexture(new ResourceLocation(KingdomKeys.MODID, "textures/gui/menu/mouse_icons.png"));
			RenderSystem.color4f(1, 1, 1, 1);
			text = "Back";
			blit(width - minecraft.fontRenderer.getStringWidth(text) - 25, 19, 14, 35, 15, 20);
			drawString(minecraft.fontRenderer, text, width - minecraft.fontRenderer.getStringWidth(text) - 5, 25, 0xF58B33);
		}
		RenderSystem.popMatrix();
	}

	public void drawMunnyTime() {
		RenderSystem.pushMatrix();
		{
			
			RenderSystem.scaled(1.1, 1.1, 1);
			drawString(minecraft.fontRenderer, (Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(minecraft.world) + ":" + getWorldMinutes(minecraft.world), 5, (int) (topBarHeight + middleHeight) + minecraft.fontRenderer.FONT_HEIGHT, 0xFFFFFF);
			drawString(minecraft.fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Munny) + ": " + ModCapabilities.get(minecraft.player).getMunny(), 5, (int) (topBarHeight + middleHeight), 0xF66627);
			long seconds = minecraft.world.getWorld().getDayTime() / 20;
			long h = seconds / 3600;
			long m = seconds % 3600 / 60;
			long s = seconds % 3600 % 60;

			String sec = s < 10 ? 0 + "" + s : s + "";
			String min = m < 10 ? 0 + "" + m : m + "";
			String hou = h < 10 ? 0 + "" + h : h + "";
			String time = hou + ":" + min + ":" + sec;
			drawString(minecraft.fontRenderer, (Strings.Gui_Menu_Main_Time_Spent) + ": " + time, 5, (int) (topBarHeight + middleHeight) + (minecraft.fontRenderer.FONT_HEIGHT * 2), 0x42ceff);
		}
		RenderSystem.popMatrix();
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(KingdomKeys.MODID, "textures/gui/menubg.png");
	public static final ResourceLocation menu = new ResourceLocation(KingdomKeys.MODID, "textures/gui/menu/menu_button.png");

	public static String getWorldMinutes(World world) {
		int time = (int) Math.abs((world.getGameTime() + 6000) % 24000);
		if ((time % 1000) * 6 / 100 < 10)
			return "0" + (time % 1000) * 6 / 100;
		else
			return Integer.toString((time % 1000) * 6 / 100);
	}

	public static int getWorldHours(World world) {
		int time = (int) Math.abs((world.getGameTime() + 6000) % 24000);
		return (int) (time / 1000F);
	}

	public void init() {
		// ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		// setWorldAndResolution(Minecraft.getMinecraft(), sr.getScaledWidth(),
		// sr.getScaledHeight());
		topBarHeight = (float) height * 0.17F;
		bottomBarHeight = (float) height * 0.23F;
		topLeftBarWidth = (float) width * 0.175F;
		topRightBarWidth = (float) (width) * 0.82F;
		topGap = (float) width * 0.005F;
		bottomLeftBarWidth = (float) width * 0.304F;
		bottomRightBarWidth = (float) width * 0.6875F;
		bottomGap = (float) width * 0.0085F;
		middleHeight = (float) height * 0.6F;
		topLeftBar = new GuiElementBar(-10, -10, (int) topLeftBarWidth + 10, (int) topBarHeight + 10, true);
		topRightBar = new GuiElementBar((int) (topLeftBarWidth + topGap), -10, (int) topRightBarWidth + 10, (int) topBarHeight + 10, true);
		bottomLeftBar = new GuiElementBar(-10, (int) (topBarHeight + middleHeight), (int) bottomLeftBarWidth + 10, (int) bottomBarHeight + 10, false);
		bottomRightBar = new GuiElementBar((int) (bottomLeftBarWidth + bottomGap), (int) (topBarHeight + middleHeight), (int) bottomRightBarWidth + 10, (int) bottomBarHeight + 10, false);
	}

	protected void drawBackground(int screenWidth, int screenHeight, boolean drawPlayer) {
		// Minecraft.getInstance().renderEngine.bindTexture(optionsBackground);
	}

}