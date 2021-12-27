import com.checkout.CheckOut;

def call(def conf=[:]) {
node {
    new CheckOut(this).execute( ,'CheckOut')
}
}
