package com.checkout;

public class ReadSpecFile{

 private final Script script

    ReadSpecFile(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Read Specfile") {
    script.stage(name) {
      script{
        script{                                      
                   bat "echo ${conf.url}"
		   checkOut.startBuild(conf)
		   bat 'echo "read yml start"'
		   def buildData = readYaml (file: 'build.yml') 
		   def deployData = readYaml (file: 'deploy.yml') 
		   bat 'echo "read yml start"'
		   bat "echo ${buildData}"	
		   bat "echo ${deployData}"
	           env.buildRequired=buildData.application.buildRequired
		   conf.put('isBuildRequired', buildData.application.buildRequired);
		   conf.put('buildType', buildData.application.buildType);
		   conf.put('deployRequired', deployData.application.deployRequired);
	           conf.put('tomcatId', deployData.application.tomcatId);
		   conf.put('tomcatUrl', deployData.application.tomcatUrl);
		   conf.put('contextPath', deployData.application.contextPath);	 		   
		   bat "echo ${env.buildRequired}"
		   bat "echo conf: ${conf}" 
                 }
      }
        }
    }
}
