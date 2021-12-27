package com.build;

public class Build {
  private final Script script

    Build(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Build") {
        script.stage(name) {
          script.tool maven='MAVEN_PATH'
          script.tool jdk='JAVA_HOME'
        
       				
            
            script.bat "java -version"
            script.bat "echo 'Execute your desired bash command here'"
            script.git url:conf.url, branch:conf.branch
        }
    }
}
