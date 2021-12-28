package com.checkout

public class CheckOut {
  //private final Script script

    //CheckOut(Script script) {
    CheckOut() {
    //    this.script = script
    }
/*
  void execute(def conf = [:], String name="Check out A") {
        script.stage(name) {
            script.bat "echo Triggering ${name} stage..."
            script.bat "echo 'Execute your desired bash command here'"
            script.git url:conf.url, branch:conf.branch
        }
    }*/
    void execute(def conf = [:], String name="Check out A") {
        stage(name) {
            bat "echo Triggering ${name} stage..."
            bat "echo 'Execute your desired bash command here'"
            git url:conf.url, branch:conf.branch
        }
    }
}
