package com.build;

public class Build {
  private final Script script

    Build(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Build") {
        script.stage(name) {
          def mvn_version = 'MAVEN_PATH'
        withEnv(["PATH+MVN=${tool mvn_version}/bin"]){
          script.echo "${PATH}"
            script.echo "mvn --version"
        }
       				
            
            script.bat "java -version"
            script.bat "echo 'Execute your desired bash command here'"
            script.git url:conf.url, branch:conf.branch
        }
    }
}
