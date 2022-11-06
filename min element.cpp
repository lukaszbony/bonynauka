#include <iostream>
#include <vector>

std::vector<int>::iterator min_element(std::vector<int>::iterator a, std::vector<int>::iterator b)
{
    if (a == b)
    {
        return b;
    }

    int min1 = *a;
    auto miniter = a;
    while (a != b)
    {
        if (min1 > *a)
        {
            min1 = *a;
            miniter = a;
        }
        ++a;
    }
    return miniter;
}

std::vector<int>::const_iterator min_element(std::vector<int>::const_iterator a, std::vector<int>::const_iterator b)
{
    if (a == b)
    {
        return b;
    }

    int min1 = *a;
    auto miniter = a;
    while (a != b)
    {
        if (min1 > *a)
        {
            min1 = *a;
            miniter = a;
        }
        ++a;
    }
    return miniter;
}

int main()
{
	std::vector<int> vector{7, 5, 1, 12, 8};
	auto result1 = min_element(vector.begin(), vector.end());
	auto result2 = min_element(vector.cbegin(), vector.cend());
	std::cout << result1 - vector.begin() << " " << result2 - vector.cbegin() << std::endl;
}
