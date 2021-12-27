package com.deploy;

public class Deploy {
   private final Script script

    Deploy(Script script) {
        this.script = script
    }
   public void execute(def conf=[:], String name='Deploy'){
       script.stage(name) {
         script.deploy adapters: [script.tomcat8(credentialsId: conf.tomcatId, path: '', url: conf.tomcatUrl)], contextPath: conf.contextPath, onFailure: false, war: 'target/*.war'
       }
   }
}
