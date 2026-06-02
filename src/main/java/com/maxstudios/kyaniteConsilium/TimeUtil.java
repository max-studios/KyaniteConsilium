package com.maxstudios.kyaniteConsilium;

import org.bukkit.World;

public class TimeUtil {

        private TimeUtil() {}

        public static String getFormattedTime(World world) {
            long ticks = world.getTime();
            long hours = (ticks / 1000 + 6) % 24;
            long minutes = (ticks % 1000) * 60 / 1000;
            return String.format("%02d:%02d", hours, minutes);
        }
    }