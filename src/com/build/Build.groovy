package com.build;

public class Build {
  private final Script script
  //def maven;

    Build(Script script) {
        this.script = script
      //this.maven = script.tool 'MAVEN_PATH'
    }

  public void execute(def conf = [:], String name="Build") {
    def maven = script.tool 'MAVEN_PATH'
    def jdk = script.tool 'JAVA_HOME'
        script.stage(name) {
          script.withEnv(["PATH+MVN=${script.tool 'MAVEN_PATH'}/bin"]){
           script.bat '''
                echo "PATH = ${PATH}"
            '''         
        }
          script.bat "set PATH=%PATH%;${jdk}\\bin"
          script.bat "${maven}/bin/mvn --version"
          script.bat "${jdk}/bin/java -version"
          script.bat "java -version"
          script.bat "echo %PATH%"
          script.withEnv(["JAVA_HOME=${jdk}/bin"]) {
                    //script.bat "${JAVA_HOME}/java -version"
                    script.bat "${maven}/bin/mvn clean package  -DskipTests"
                }
          
          archive();
        }
    }
  
    public void archive(String name="Archive") {
    script.stage(name) {
      script.archiveArtifacts artifacts: 'target/*.war', fingerprint: true
    }
  }
}
