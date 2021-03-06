package com.company;

public class Runner extends Thread {

    private Runner runner1;
    private Runner runner2;

    public Runner (String name){
        super(name);
    }

    public void setRunner(Runner runner1, Runner runner2){
        this.runner1=runner1;
        this.runner2=runner2;

    }

    @Override
    public void run() {

        if(getName().equals("Runner5")){
            System.out.println(getName() + " берет палочку");
            try {
                sleep(2000);
            } catch (Exception ignored) {
            }

            System.out.println(getName() + " бежит к " + runner1.getName());
            try {
                sleep(2000);
            } catch (Exception ignored) {
            }
        }
        else {
            System.out.println(getName() + " берет палочку");
            System.out.println(getName() + " бежит к " + runner2.getName());
            try {
                sleep(2000);
            } catch (Exception ignored) {
            }

            runner2.start();
            try {
                runner2.join();
            } catch (Exception ignored) {
            }
            System.out.println(getName() + " берет палочку");
            try {
                sleep(2000);
                if(!getName().equals("Runner5") && !getName().equals("Runner1")){
                    System.out.println(getName() + " бежит к " + runner1.getName());
                    try{
                        sleep(2000);
                    } catch (Exception ignored){
                    }
                }
            } catch (Exception ignored) {
            }

        }
    }
}
