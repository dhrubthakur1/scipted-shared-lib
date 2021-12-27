import com.checkout.*;
import com.build.*;
import com.deploy.*;

def call(def conf=[:]) {
   node {
    new CheckOut(this).execute( conf,'CheckOut')
    new ReadSpecFile(this).execute(conf,'Read Spec')  
     cleanWs()
  }
}

def buildAndDeploy(def conf=[:]) {
   node {
      cleanWs()
    new CheckOut(this).execute( conf,'CheckOut')   
    if(conf.isBuildRequired == 'Yes' && conf.buildType == 'Java'){
      new com.build.Build(this).execute(conf,'Build')      
    } else {
      bat "echo  Not a maven project"
    }
    if(conf.deployRequired == 'Yes'){      
      new com.deploy.Deploy(this).execute(conf,'Deploy')
    } else {
      bat "echo  Deploymment nit required"
    }
  }
}
