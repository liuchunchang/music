package com;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ms extends Thread {
        private String filename;
        public Player player;

        public ms(String filename) {
            this.filename = filename;
            try {
                BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
                player = new Player(buffer);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        @Override
        public void run() {
            try {
                    player.play();

            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }


