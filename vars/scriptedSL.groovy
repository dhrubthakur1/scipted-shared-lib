import com.checkout.*;
import com.build.*;

def call(def conf=[:]) {
   node {
    new CheckOut(this).execute( conf,'CheckOut')
    new ReadSpecFile(this).execute(conf,'Read Spec')
    stage.bat "echo ${conf}"
    new com.build.Build(this).execute(conf,'Build')
}
}
