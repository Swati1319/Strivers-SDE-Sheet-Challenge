/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where 'N' is the length of the string.
*/

// Recursive helper function to convert a string to an integer.
int atoi(int ind, int ans, string& str) {
    // Base case: if we reach the end of the string.
    if (ind == str.size()) {
        return ans;
    }
    
    // Check if the character at the current index is a digit.
    if ('0' <= str[ind] && str[ind] <= '9') {
        // Convert the digit character to an integer and update the answer.
        return atoi(ind + 1, 10 * ans + str[ind] - '0', str);
    } else {
        // Move to the next index and continue the recursion without changing the answer.
        return atoi(ind + 1, ans, str);
    }
}

// Main function to convert a string to an integer.
int atoi(string str) {
    int num = atoi(0, 0, str);
    
    // Check if the number is negative.
    if (str[0] == '-') {
        num *= -1;
    }
    
    // Return the resulting number.
    return num;
}
