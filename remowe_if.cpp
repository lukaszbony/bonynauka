#include <iostream>
#include <functional>
#include <vector>

template<typename Iter, typename Function>
Iter remove_if(Iter begin, Iter end, Function func)
{
    auto replace = begin;

    while (begin != end)
    {
        if (!func(*begin))
        {
            iter_swap(replace, begin);
            ++replace;
        }
        ++begin;
    }
    return replace;
}

int main()
{
    std::vector<int> vector {-7, 5, 2, 2, 11, 2, 3};
    auto result = remove_if(vector.begin(), vector.end(), [](int element) {return element < 3;});
    for (auto iterator = vector.cbegin(); iterator < result;)
    {
        std::cout << *iterator++ << " ";
    }
    std::cout << std::endl;
}
