package com.build;

public class Build {
  private final Script script
 
    Build(Script script) {
        this.script = script
    }

  public void execute(def conf = [:], String name="Build") {
    def maven = script.tool 'MAVEN_PATH'
    //def jdk = script.tool 'JAVA_HOME'
        script.stage(name) {
          
         script.env.JAVA_HOME="${script.tool 'JAVA_HOME'}"
         script.env.PATH="${script.env.JAVA_HOME}/bin:${script.env.PATH}"
              
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
