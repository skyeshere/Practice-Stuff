use std::io;

fn take_user_input() -> String
{
    let mut buffer = String::new();
    let stdin = io::stdin();
    stdin.read_line(&mut buffer).expect("failed to read line");

    return buffer.trim().to_string();
}

fn rotate_array(mut array: [i32; 4], direction: String) -> [i32; 4]
{
    let temp_digit: i32; //temp digit for either rotation
    if direction == "clockwise" //shifting to the right ->
    {
        temp_digit = array[3];
        for i in (1.. array.len()).rev()
        {
            array[i] = array[i - 1];
        }
        array[0] = temp_digit;
    }
    
    else if direction == "counterclockwise" //shifting to the left <-
    {
        temp_digit = array[0];

        for i in 1.. array.len()
        {
            array[i - 1] = array[i];
        }

        array[array.len() - 1] = temp_digit;
    }

    return array;
}

fn main() {
    let array: [i32; 4] = [1, 2, 3, 4]; //array to be rotated
    let input = take_user_input(); // inpupt for which way the array is to be rotated
    let new_array: [i32; 4] = rotate_array(array, input); // rotated array as new array

    //print new array
    for num in new_array
    {
        print!("{}, ", num);
    }
}
