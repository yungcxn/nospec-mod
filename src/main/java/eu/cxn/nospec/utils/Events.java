package eu.cxn.nospec.utils;

import java.util.Collection;

import eu.cxn.nospec.NoSpec;
import eu.cxn.nospec.elo.EloCalculator;
import eu.cxn.nospec.gui.MainGui;
import eu.cxn.nospec.setting.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.command.ICommandSender;

public class Events
{
  public static NoSpec burningMod;
  private ArrayList<EntityPlayer> epearl = new ArrayList();
  private ArrayList<EntityPlayer> strength = new ArrayList();
  private ArrayList<EntityPlayer> fns = new ArrayList();
  private ArrayList<EntityPlayer> ironsw = new ArrayList();
  private ArrayList<EntityPlayer> sheep = new ArrayList();
  private ArrayList<EntityPlayer> tnt = new ArrayList();
  private ArrayList<EntityPlayer> ironpick = new ArrayList();
  private ArrayList<EntityPlayer> playerPos = new ArrayList();
  
  //ProjectileHitEvent.getEntity()
  
  @SubscribeEvent
  public void onRender(RenderGameOverlayEvent e)
  {
	  
    if (Settings.getState("EP"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          if (entityPlayer.getHeldItem().getItem() == Item.getItemById(368))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.epearl.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " hat eine " + EnumChatFormatting.GOLD + "EP"));
              this.epearl.add(entityPlayer);
            }
          }
          else if (this.epearl.contains(entityPlayer)) {
            this.epearl.remove(entityPlayer);
          }
        }
      }
   
    }
    
    //potion
    if (Settings.getState("POTION"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          if (entityPlayer.getHeldItem().getItem() == Item.getItemById(373))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.strength.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " hat einen " + EnumChatFormatting.GOLD + "Trank"));
              this.strength.add(entityPlayer);
            }
          }
          else if (this.strength.contains(entityPlayer)) {
            this.strength.remove(entityPlayer);
          }
        }
      }
   
    }
    
    //flint
    if (Settings.getState("FNS"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          if (entityPlayer.getHeldItem().getItem() == Item.getItemById(259))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.fns.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " hat ein " + EnumChatFormatting.GOLD + "Feuerzeug"));
              this.fns.add(entityPlayer);
            }
          }
          else if (this.fns.contains(entityPlayer)) {
            this.fns.remove(entityPlayer);
          }
        }
      }
   
    }
    
    //ironsw
    if (Settings.getState("SWORD"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          if (entityPlayer.getHeldItem().getItem() == Item.getItemById(267))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.ironsw.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " hat ein " + EnumChatFormatting.GOLD + "Eisenschwert"));
              this.ironsw.add(entityPlayer);
            }
          }
          else if (this.ironsw.contains(entityPlayer)) {
            this.ironsw.remove(entityPlayer);
          }
        }
      }
   
    }
    
    
    
    //schafe
    if (Settings.getState("SHEEP"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          if (entityPlayer.getHeldItem().getItem() == Item.getItemById(383))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.sheep.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " hat " + EnumChatFormatting.GOLD + "Schafe"));
              this.sheep.add(entityPlayer);
            }
          }
          else if (this.sheep.contains(entityPlayer)) {
            this.sheep.remove(entityPlayer);
          }
        }
      }
   
    }
    
  //ironpick
    if (Settings.getState("PICK"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          if (entityPlayer.getHeldItem().getItem() == Item.getItemById(257))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.ironpick.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " hat eine " + EnumChatFormatting.GOLD + "Eisenpicke"));
              this.ironpick.add(entityPlayer);
            }
          }
          else if (this.ironpick.contains(entityPlayer)) {
            this.ironpick.remove(entityPlayer);
          }
        }
      }
   
    }
    
    
    
  //Player Position ueber gewisser hoehe (169)
    if (Settings.getState("POS"))
    {
      for (EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
        if (entityPlayer.getHeldItem() != null) {
          
          if (entityPlayer.posY >= (double)(Settings.getPosHeight()))
          {
            if ((entityPlayer.getCommandSenderEntity().getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) && 
              (!this.playerPos.contains(entityPlayer)))
            {
              Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "[NoSpec] " +  EnumChatFormatting.DARK_RED + entityPlayer.getCommandSenderEntity().getName() + EnumChatFormatting.GRAY + " ist auf dem " + EnumChatFormatting.GOLD + "OP-Weg"));
              this.playerPos.add(entityPlayer);
            }
          }
          else if (this.playerPos.contains(entityPlayer)) {
            this.playerPos.remove(entityPlayer);
          }
        }
      }
   
    }
    
    
  }
  
  //other events: 
  
  @SubscribeEvent
  public void onClientTick(TickEvent.ClientTickEvent e)
  {
    if (MainGui.showMainGui)
    {
      Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new MainGui());
      MainGui.showMainGui = false;
    }
  }
  
  
  
  /*
   * 
   * RENDER ON SCREEN SOME TEXT LIKE IN GUI WITH FONTRENDEREROBJ.DRAW....
   * 
   * @SubscribeEvent
    public void RenderGameOverlayEvent(RenderGameOverlayEvent event)
    {
     //render everything onto the screen
     if(event.type == RenderGameOverlayEvent.ElementType.TEXT)
     {
            //do rendering
     }
    }
   * 
   * 
   */
  
  

}
