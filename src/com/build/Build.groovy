package com.build;

public class Build {
  private final Script script

    Build(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Build") {
        script.stage(name) {
          script.withEnv(["PATH+MVN=${script.tool 'MAVEN_PATH'}/bin"]){
           script.bat '''
                echo "PATH = ${PATH}"
            '''         
        }
          script.bat "echo ${JAVA_HOME}"
          script.bat "echo ${MAVEN_HOME}"
          script.bat "echo ${MAVEN_PATH}"
          script.bat "echo ${PATH}"
            script.bat "mvn --version"
            script.bat "java -version"
            script.bat "echo 'Execute your desired bash command here'"
            script.git url:conf.url, branch:conf.branch
        }
    }
}
