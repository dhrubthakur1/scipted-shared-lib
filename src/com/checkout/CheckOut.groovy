package com.checkout

public class CheckOut {
  private final Script script

    CheckOut(Script script) {    
        this.script = script      
    }

  void execute(def conf = [:], String name="Check out A") {
    script.bat "echo ${script.stage('Test').getClass()}"
        script.stage(name) {
            script.bat "echo Triggering ${name} stage..."    
            script.bat "echo ${script.getClass()}"
            script.git url:conf.url, branch:conf.branch
        }
    }
}
