#include <iostream>
#include <vector>

std::vector<int>::iterator partial_sum(std::vector<int>::const_iterator a, std::vector<int>::const_iterator b, std::vector<int>::iterator result)
{
    int sum = 0;
    while (a != b)
    {
        sum += *a;
        *result = sum;
        ++a;
        ++result;
    }
    return result;
}

int main()
{
	std::vector<int> vector {3, 2, -1, 3, 4};
	auto result = partial_sum(vector.cbegin(), vector.cend(), vector.begin());
	for (auto iterator = vector.cbegin(); iterator < result; )
    {
        std::cout << *iterator++ << " ";
    }
    std::cout << std::endl;
}
