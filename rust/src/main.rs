mod n1572_matrix_diagonal_sum;
mod n3360_stone_removal_game;
mod n3364_minimum_positive_sum_subarray;
mod n3423_maximum_difference_between_adjacent_elements_in_a_circular_array;
mod n350_intersection_of_two_arrays_ii;
mod n541_reverse_string_ii;

fn main() {
    // let res =
    //     n350_intersection_of_two_arrays_ii::intersect(vec![4, 9, 5], vec![9, 4, 9, 8, 4]);
    // println!("res: {:?}", res);
    // let res = n3364_minimum_positive_sum_subarray::Solution::minimum_sum_subarray(
    //     vec![-2, 2, -3, 1],
    //     2,
    //     3,
    // );
    // println!("res = {}", res);
    // let res = n3364_minimum_positive_sum_subarray::Solution::minimum_sum_subarray(
    //     vec![3, -2, 1, 4],
    //     2,
    //     3,
    // );
    // println!("res = {}", res);
    let res = n3364_minimum_positive_sum_subarray::Solution::minimum_sum_subarray(
        vec![7,3],
        2,
        2,
    );
    println!("res = {}", res);
}
