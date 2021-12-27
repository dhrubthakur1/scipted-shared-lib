import com.checkout.CheckOut;

def call(def conf=[:]) {
   node {
    new com.checkout.CheckOut(this).execute( conf,'CheckOut')
}
}
