import com.checkout.*;
import com.build.*;

def call(def conf=[:]) {
   node {
    new CheckOut(this).execute( conf,'CheckOut')
    new ReadSpecFile(this).execute(conf,'Read Spec')    
    new com.build.Build(this).execute(conf,'Build')
}
}
