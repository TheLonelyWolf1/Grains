package si.zbe.grains.events;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import si.zbe.grains.utils.ItemManager;

public class WorkbenchClick implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("grains.workbench"))
            return;

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            final ItemStack itemInHand = p.getInventory().getItemInMainHand();
            final ItemStack itemInOffHand = p.getInventory().getItemInOffHand();

            if (itemInHand.getType() == Material.CRAFTING_TABLE) {

                if (!itemInHand.hasItemMeta())
                    return;

                if (!itemInHand.getItemMeta().equals(ItemManager.workbench.getItemMeta()))
                    return;


                p.openWorkbench(null, true);
                p.updateInventory();
                e.setCancelled(true);
            } else if (itemInOffHand.getType() == Material.CRAFTING_TABLE) {
                if (!itemInOffHand.hasItemMeta())
                    return;

                if (!itemInOffHand.getItemMeta().equals(ItemManager.workbench.getItemMeta()))
                    return;

                p.openWorkbench(null, true);
                p.updateInventory();
                e.setCancelled(true);
            }
        }
    }
}