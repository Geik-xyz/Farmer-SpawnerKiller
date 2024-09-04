package xyz.geik.farmer.modules.spawnerkiller.configuration;

import lombok.Getter;
import lombok.Setter;
import xyz.geik.glib.shades.okaeri.configs.OkaeriConfig;
import xyz.geik.glib.shades.okaeri.configs.annotation.Comment;
import xyz.geik.glib.shades.okaeri.configs.annotation.NameStrategy;
import xyz.geik.glib.shades.okaeri.configs.annotation.Names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Modules file
 *
 * @author geik
 * @since 2.0
 */
@Getter
@Setter
@Names(strategy = NameStrategy.IDENTITY)
public class ConfigFile extends OkaeriConfig {

    @Comment({"if you want to use spawner killer system",
            "set feature to true.",
            "and players with farmer.admin permission can give spawner killer.",
            "you can disable buy feature and give farmer with command"})
    private boolean status = false;

    @Comment({"if you want to kill mobs without farmer set it false"})
    private boolean requireFarmer = true;

    @Comment({"cook foods on spawner drop"})
    private boolean cookFoods = true;

    @Comment({"remove mob can't see mob only spawn item."})
    private boolean removeMob = true;

    @Comment({"default status for spawner killer when farmer place",
            "if set true, farmer will be enable spawner killer by default",
            "if set false, farmer will be disable spawner killer by default"})
    private boolean defaultStatus = true;

    @Comment({"custom perm for spawner killer status changer"})
    private String customPerm = "farmer.spawnerkiller";

    @Comment({"set whitelist mobs for spawner killer",
            "if you want to kill only whitelist mobs, set mode to whitelist",
            "if you want to kill all mobs except blacklist mobs, set mode to blacklist"})
    private String mode = "blacklist";

    @Comment({"You can add remove blacklist section",
            "if you want to remove mobs from blacklist"})
    private List<String> whitelist = Arrays.asList("VILLAGER");

    @Comment({"You can add remove blacklist section",
            "if you want to remove mobs from blacklist"})
    private List<String> blacklist = Arrays.asList("VILLAGER");

}