package com.gmail.kurumi78.bush.events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BushClick implements Listener {

    @EventHandler
    public void OnBushClick(final PlayerInteractEvent event){
        if(event.getClickedBlock() != null) {
            if (event.getClickedBlock().getType().equals(Material.DEAD_BUSH)) {
                if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BONE_MEAL)) {
                    Location bushLoc = event.getClickedBlock().getLocation();
                    World world = event.getClickedBlock().getWorld();
                    Random rand = new Random();
                    int treeHeight = rand.nextInt(4) + 3;
                    isClear(treeHeight, bushLoc);
                    bushLoc.setY(bushLoc.getY() - treeHeight);
                    placeTree(treeHeight, bushLoc, world);

                    if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                        ItemStack newMeal = event.getPlayer().getInventory().getItemInMainHand();
                        newMeal.setAmount(newMeal.getAmount() - 1);
                        event.getPlayer().getInventory().setItemInMainHand(newMeal);
                    }

                }
            }
        }

    }

    public void placeTree(int height, Location loc, World tworld){
        for(int x = 0; x < height; x++){
           tworld.getBlockAt(loc).setType(Material.OAK_LOG);
            loc.setY(loc.getY()+1);
        }
    }

    public boolean isClear(int height, Location loc){
        for(int x = 0; x < height; x++){
            loc.setY(loc.getY()+1);
            if(!loc.getBlock().getType().equals(Material.AIR)){
                return false;
            }
        }
        return true;

    }
}
