package com.checkout;

public class ReadSpecFile{

 private final Script script

    ReadSpecFile(Script script) {
        this.script = script
    }

  void execute(def conf = [:], String name="Read Specfile") {

    script.stage(name) {
     script.bat "dir"
     def buildData = readYaml (file: 'build.yml') 
    }
}
}
