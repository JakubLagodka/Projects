import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
//Vending Machine
//Assuming the vending machine has an infinite supply of coins, calculate the minimum number of coins required to provide the change.
//Say if you are buying a soda from a vending machine which costs 1.5$ and you insert two 1$ bill,
// how vending machine can provide a change with minimum number of coins?
//Assume Vending machine have 1,2,5,10,20,50,100 cents multiple coins.
//Inputs
//•	productCost - The cost of the product
//•	insertedCoins - List of coins which have been inserted into the machine in the order that the customer inserted them
//•	coinSystem - A list of coins that are recognised by the machine
//The order of coinSystem cannot be assumed.
//Outputs
//•	coins - The coins needed to provide the change.
//Example
//Sample Inputs
//•	productCost - $1.50
//•	insertedCoins - 100, 100
//•	coinSystem - [1, 2, 5, 10, 20, 50, 100, 200]
//Sample Output
//•	coins - 1 x 50
//We expect one as the smallest number of coins is a single 50.

class ChangeCalculatorTest {

    @Test
    fun `Calculate change for purchase with non-exact change`() {
        val coins = HashSet<Int>()
        coins.add(1)
        coins.add(2)
        coins.add(5)
        coins.add(10)
        coins.add(20)
        coins.add(50)
        coins.add(100)

        val changeGiven = ChangeCalculatorKt.calculateMinCoinsForChange(BigDecimal("1.50"), listOf(100, 100), coins)

        val expected: MutableMap<Int, Int> = HashMap()
        expected[1] = 50
        Assertions.assertEquals(expected, changeGiven)
    }
}