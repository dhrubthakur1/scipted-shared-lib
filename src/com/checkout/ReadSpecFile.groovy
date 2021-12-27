package com.checkout;

public class ReadSpecFile{

 private final Script script

    ReadSpecFile(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Read Specfile") {
    script.stage(name) {
     script.bat "echo ${conf.url}"		   
		   script.bat 'echo "read yml start"'
		   script.bat "def buildData = readYaml (file: 'build.yml') "
		   script.bat "def deployData = readYaml (file: 'deploy.yml') "
		   script.bat 'echo "read yml start"'
		   script.bat "echo ${buildData}"	
		   script.bat "echo ${deployData}"	          
		   script.bat "echo conf: ${conf}" 
        }
    }
}
