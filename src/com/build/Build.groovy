package com.build;

public class Build {
  private final Script script

    Build(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Build") {
        script.stage(name) {
        def	maven ='MAVEN_PATH'
        def  jdk ='JAVA_HOME'
       				
            script.bat "echo Triggering ${name} stage..."
            script.bat "echo 'Execute your desired bash command here'"
            script.git url:conf.url, branch:conf.branch
        }
    }
}
