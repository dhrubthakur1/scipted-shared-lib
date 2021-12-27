package com.checkout;

public class ReadSpecFile{

 private final Script script

    ReadSpecFile(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Read Specfile") {
	  script{
	  	def buildData = readYaml (file: 'build.yml') 
	  }
    script.stage(name) {
     script.bat "echo ${conf.url}"		   
		   script.bat 'echo "read yml start"'		   
        }
    }
}
