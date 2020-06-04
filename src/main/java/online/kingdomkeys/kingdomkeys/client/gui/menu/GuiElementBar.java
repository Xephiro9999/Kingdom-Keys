package online.kingdomkeys.kingdomkeys.client.gui.menu;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import online.kingdomkeys.kingdomkeys.KingdomKeys;

public class GuiElementBar extends Screen {

    int posX, posY, width, height;
    boolean flipGradient;

    public GuiElementBar(int posX, int posY, int width, int height, boolean flipGradient) {
		super(new TranslationTextComponent(""));
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.flipGradient = flipGradient;
    }

    private final ResourceLocation texture = new ResourceLocation(KingdomKeys.MODID, "textures/gui/menu/menu_button.png");

    private final int borderSize = 10;
    private final int
            tlCornerU = 77, tlCornerV = 67,
            blCornerU = 77, blCornerV = 80,
            trCornerU = 90, trCornerV = 67,
            brCornerU = 90, brCornerV = 80,
            lCenterU = 77, lCenterV = 78,
            tCenterU = 88, tCenterV = 67,
            rCenterU = 90, rCenterV = 78,
            bCenterU = 88, bCenterV = 80
    ;

    private final int gradientU = 101, gradientV = 67, gradientW = 10, gradientH = 32;

    public void draw() {
        minecraft = Minecraft.getInstance();
        minecraft.textureManager.bindTexture(texture);
        //Top left corner
        blit(posX, posY, tlCornerU, tlCornerV, borderSize, borderSize);
        //Top right corner
        blit(posX + width - borderSize, posY, trCornerU, trCornerV, borderSize, borderSize);
        //Bottom left corner
        blit(posX, posY + height - borderSize, blCornerU, blCornerV, borderSize, borderSize);
        //Bottom right corner
        blit(posX + width - borderSize, posY + height - borderSize, brCornerU, brCornerV, borderSize, borderSize);
        int centerWidth = width - (borderSize * 2);
        int centerHeight = height - (borderSize * 2);
        //Center border
        for (int i = 0; i < centerWidth; i++) {
            //Top
        	blit(posX + borderSize + i, posY, tCenterU, tCenterV, 1, borderSize);
            //Bottom
        	blit(posX + borderSize + i, posY + height - borderSize, bCenterU, bCenterV, 1, borderSize);
        }
        for (int i = 0; i < centerHeight; i++) {
            //Left
        	blit(posX, posY + borderSize + i, lCenterU, lCenterV, borderSize, 1);
            //Right
        	blit(posX + width - borderSize, posY + borderSize + i, rCenterU, rCenterV, borderSize, 1);
        }
        //Inside
        RenderSystem.pushMatrix();
        RenderSystem.translated(posX + borderSize, posY + borderSize, 0);
        RenderSystem.scaled(centerWidth, (float)centerHeight / (float)gradientH,1);
        if (flipGradient) {
        	blit(0, 0, gradientU + 11, gradientV, 1, gradientH);
        } else {
        	blit(0, 0, gradientU, gradientV, 1, gradientH);
        }
        RenderSystem.popMatrix();
        //drawModalRectWithCustomSizedTexture(posX + borderSize, posY + borderSize, gradientU, gradientV, centerWidth, centerHeight, gradientW, gradientH);
        //drawScaledCustomSizeModalRect(posX + borderSize, posY + borderSize, gradientU, gradientV, gradientW, gradientH, centerWidth, centerHeight, centerWidth, centerHeight);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
