#include <iostream>
#include <sstream>
#include <fstream>
#include <vector>

struct Student
{
    std::string imie;
    std::vector<double> oceny;

    Student(const std::string& imie, const std::vector<double>& oceny) : imie(imie), oceny(oceny) {}
};

int main(int argc, char* argv[])
{
    std::stringstream ss;
    std::fstream plik(argv[1], std::ios::in);
    std::vector<Student> studenci;

    std::string linia;
    getline(plik, linia);
    std::vector<double> maksymalneOceny;
    ss << linia;
    double n;
    while (ss >> n)
    {
        maksymalneOceny.push_back(n);
    }

    std::string nazwa;
    while (plik >> nazwa)
    {
        std::vector<double> oceny(maksymalneOceny.size());
        for (int i = 0; i < oceny.size(); ++i)
        {
            plik >> oceny[i];
        }
        studenci.push_back(Student(nazwa, oceny));
    }

    for (int i = 0; i < studenci.size(); ++i)
    {
        const auto& s = studenci[i];
        std::cout << s.imie<< ' ' ;
        double suma = 0;
        for (int j = 0; j < s.oceny.size(); ++j)
        {
            suma += s.oceny[j];
        }
        std::cout << suma << '\n';
    }
    std::cout << '\n';
    for (int i = 0; i < maksymalneOceny.size(); ++i)
    {
        double srednia = 0;
        for (int j = 0; j < studenci.size(); ++j)
        {
            srednia += studenci[j].oceny[i];
        }
        srednia /= maksymalneOceny.size();
        std::cout << i + 1 << ' ' << srednia << '\n';
    }
}
