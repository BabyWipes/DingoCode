package com.huskehhh.dingocode;

import com.huskehhh.dingocode.database.mysql.MySQL;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DingoUtil {

    private static YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/DingoCurrency/config.yml"));

    public static MySQL mysql = new MySQL(config.getString("MySQL.host"), config.getString("MySQL.port"), config.getString("MySQL.database"), config.getString("MySQL.user"), config.getString("MySQL.password"));

    public static int getGems(Player p) {
        String query = "SELECT gems FROM `data` WHERE name LIKE " + p.getName() + ";";
        ResultSet rs = mysql.querySQL(query);
        try {
            if (!rs.next()) {
                setGems(p, 0);
            } else {
                return rs.getInt("gems");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setGems(Player p, int gems) {
        String execute = "UPDATE gems FROM `data` WHERE name LIKE " + p.getName() + " VALUES (" + gems + ");";
        mysql.updateSQL(execute);
    }

    public static int getTokens(Player p) {
        String query = "SELECT tokens FROM `data` WHERE name LIKE " + p.getName() + ";";
        ResultSet rs = mysql.querySQL(query);
        try {
            if (!rs.next()) {
                setTokens(p, 0);
            } else {
                return rs.getInt("tokens");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setTokens(Player p, int tokens) {
        String execute = "UPDATE tokens FROM `data` WHERE name LIKE " + p.getName() + " VALUES (" + tokens + ");";
        mysql.updateSQL(execute);
    }

}
