package com.build;

public class Build {
  private final Script script

    Build(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Build") {
    def maven = script.tool 'MAVEN_PATH'
        script.stage(name) {
          script.withEnv(["PATH+MVN=${script.tool 'MAVEN_PATH'}/bin"]){
           script.bat '''
                echo "PATH = ${PATH}"
            '''         
        }
          script.bat "${maven}/bin/mvn --version"
            script.bat "java -version"
            script.bat "echo 'Execute your desired bash command here'"
            script.git url:conf.url, branch:conf.branch
        }
    }
}
