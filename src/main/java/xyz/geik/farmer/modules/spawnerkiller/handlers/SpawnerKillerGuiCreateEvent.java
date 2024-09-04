package xyz.geik.farmer.modules.spawnerkiller.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import xyz.geik.farmer.api.handlers.FarmerModuleGuiCreateEvent;
import xyz.geik.farmer.helpers.gui.GuiHelper;
import xyz.geik.farmer.model.Farmer;
import xyz.geik.farmer.modules.spawnerkiller.SpawnerKiller;
import xyz.geik.glib.shades.inventorygui.DynamicGuiElement;
import xyz.geik.glib.shades.inventorygui.StaticGuiElement;

import java.util.stream.Collectors;

/**
 * Gui create event for spawner killer module
 * @author Geik
 */
public class SpawnerKillerGuiCreateEvent implements Listener {

    /**
     * Constructor of class
     */
    public SpawnerKillerGuiCreateEvent() {}

    /**
     * Creates the GUI element for the farmer GUI for the module
     *
     * @param e of farmer module gui create event
     */
    @EventHandler
    public void onGuiCreateEvent(@NotNull FarmerModuleGuiCreateEvent e) {
        char icon = SpawnerKiller.getInstance()
                .getLang().getString("moduleGui.icon.guiInterface").charAt(0);
        e.getGui().addElement(
                new DynamicGuiElement(icon, (viewer) ->
                    new StaticGuiElement(
                        icon,
                        // Item here
                        getGuiItem(e.getFarmer()),
                        1,
                        // Event written bottom
                        click -> {
                            // If player don't have permission do nothing
                            if (!e.getPlayer().hasPermission(SpawnerKiller.getInstance().getCustomPerm()))
                                return true;
                            // Change attribute
                            e.getFarmer().changeAttribute("spawnerkiller");
                            e.getGui().draw();
                            return true;
                    })
                )
        );
    }

    /**
     * Gets item of gui
     *
     * @param farmer of gui
     * @return ItemStack of gui item
     */
    private @NotNull ItemStack getGuiItem(@NotNull Farmer farmer) {
        ItemStack item = GuiHelper.getItem("moduleGui.icon", SpawnerKiller.getInstance().getLang());
        ItemMeta meta = item.getItemMeta();
        String status = farmer.getAttributeStatus("spawnerkiller") ?
                SpawnerKiller.getInstance().getLang().getText("enabled") :
                SpawnerKiller.getInstance().getLang().getText("disabled");
        meta.setLore(meta.getLore().stream().map(line -> line.replace("{status}", status))
                .collect(Collectors.toList()));
        item.setItemMeta(meta);
        return item;
    }
}
