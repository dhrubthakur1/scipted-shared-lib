package com.build;

public class Build {
  private final Script script
  def maven = script.tool 'MAVEN_PATH'

    Build(Script script) {
        this.script = script
    }

  public void execute(def conf = [:], String name="Build") {
    //def maven = script.tool 'MAVEN_PATH'
        script.stage(name) {
          script.withEnv(["PATH+MVN=${script.tool 'MAVEN_PATH'}/bin"]){
           script.bat '''
                echo "PATH = ${PATH}"
            '''         
        }
          script.bat "${maven}/bin/mvn --version"
          script.bat "java -version"
          script.bat "${maven}/bin/mvn clean package  -DskipTests"
          archive();
        }
    }
  
    public void archive(String name="Archive") {
    script.stage(name) {
      script.archiveArtifacts artifacts: 'target/*.war', fingerprint: true
    }
  }
}
