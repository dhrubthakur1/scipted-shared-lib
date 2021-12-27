import com.checkout.*;

def call(def conf=[:]) {
   node {
    new CheckOut(this).execute( conf,'CheckOut')
    new readSpecFile(this).execute(conf)
}
}

def callA() {
   node {
    new com.checkout.CheckOut(this).execute( def conf=[:],'CheckOut')
}
}
