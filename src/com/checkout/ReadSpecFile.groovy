package com.checkout;

public class ReadSpecFile{

 private final Script script

    ReadSpecFile(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Read Specfile") {

    script.stage(name) {
     script.bat "dir"
     //script.groovysh.bat "def buildData = readYaml file: 'build.yml' "
     def buildData = script.readYaml(file: 'build.yml' )
     def deployData = script.readYaml (file: 'deploy.yml') 
		   
		   script.echo " ${buildData}"	
		   script.echo " ${deployData}"
	    
		   conf.put('isBuildRequired', buildData.application.buildRequired);
		   conf.put('buildType', buildData.application.buildType);
		   conf.put('deployRequired', deployData.application.deployRequired);
	    conf.put('tomcatId', deployData.application.tomcatId);
		   conf.put('tomcatUrl', deployData.application.tomcatUrl);
		   conf.put('contextPath', deployData.application.contextPath);	 		   
		   script.echo "conf: ${conf}"   
    }       
}
}
