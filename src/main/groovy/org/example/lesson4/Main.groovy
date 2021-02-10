package org.example.lesson4

class Main {
    static void main(args){
        List order = [
                [id: 1, name: 'PC system unit', price: 500.15, quantity: 1],
                [id: 2, name: 'Monitor', price: 250.00, quantity: 2],
                [id: 3, name: 'Mouse', price: 29.99, quantity: 1],
                [id: 4, name: 'Keyboard', price: 45.99, quantity: 1],
                [id: 5, name: 'Printer', price: 400.00, quantity: 1],
                [id: 6, name: 'Audio System', price: 490.00, quantity: 1]
        ]

        // 1 Calculate the total price for the order

        double totalPrice = new Main().totalPriceOfOrder(order)
        println("The total price is $totalPrice")

        // 2 Sort and print all products by price (descending order)

        List orderedList = new Main().orderSorting(order)
        println("Sorted order by price (not taking into account product quantities): ")
        orderedList.each{product -> println(product)}

        // 3* Create method optimizeOrder

        List optimizedOrder = new Main().optimizeOrder(order, 1650)
        println("Optimezed order:")
        optimizedOrder.each {product -> println(product)}

        // Initial list

        println("Initial order:")
        order.each {product -> println(product)}
    }

    double totalPriceOfOrder (List order){
        double totalPrice = order.sum{product -> product.price * product.quantity}
        return totalPrice
    }

    List orderSorting (List order) {
        List sortedOrder = order.collectNested {product -> product}
        sortedOrder.sort{a, b -> a.price == b.price ? 0 : (a.price < b.price ? 1 : -1)}
    }

    List optimizeOrder(List order, double maxPrice){
        List optimizedOrder = order.collectNested {product -> product.collectEntries {it}}
        optimizedOrder = new Main().orderSorting(optimizedOrder)
        double totalPrice = new Main().totalPriceOfOrder(optimizedOrder)
        double removedPrice

        while (totalPrice > maxPrice){
            removedPrice = optimizedOrder[-1].price
            if (optimizedOrder[-1].quantity > 1){
                optimizedOrder[-1].quantity -= 1
            } else {
                optimizedOrder.removeLast()
            }
            totalPrice -= removedPrice
        }
        return optimizedOrder
    }
}
