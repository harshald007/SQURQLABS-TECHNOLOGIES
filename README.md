# Amazon.in UI Automation Test Suite

This project is a Selenium-based UI automation framework for testing key functionalities on [Amazon.in](https://www.amazon.in), including **Search** and **Cart** features.

---

## 🚀 Features

* Search for valid and invalid products
* Add item to cart
* Update quantity in cart
* Remove item from cart
* Page Object Model (POM) structure
* TestNG-based execution
* Cross-browser support (default: Chrome)

---

## 🛠️ Tech Stack

| Component         | Tool/Library              |
| ----------------- | ------------------------- |
| Language          | Java                      |
| Build Tool        | Maven                     |
| Automation        | Selenium WebDriver        |
| Test Framework    | TestNG                    |
| Browser Driver    | WebDriverManager (Chrome) |
| Logger (optional) | SLF4J / Logback           |

---

## 📁 Project Structure

```
amazon-automation/
├── pom.xml
├── testng.xml
├── README.md
├── /src
│   ├── /main/java/pages      # Page classes (POM)
│   └── /test/java/tests      # TestNG test classes
```

---

## 🖥️ Prerequisites

* Java 17 or newer
* Maven installed and added to PATH
* Internet connection (for WebDriverManager)

---

## 📦 Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/harshald007/SQURQLABS-TECHNOLOGIES.git
   cd SQURQLABS-TECHNOLOGIES
   ```

2. Install dependencies:

   ```bash
   mvn clean install
   ```

---

## 🧪 Running the Tests

Execute all tests defined in `testng.xml`:

```bash
mvn test
```

This runs tests in the following sequence:

1. Search for non-existing product
2. Search for existing product
3. Add item to cart
4. Update quantity in cart
5. Remove item from cart

---

## 📝 Notes

* This automation runs on **latest Chrome**. To use a different browser, modify `WebDriverManager` setup in `AmazonTests.java`.
* Amazon may block automation after too many runs. Introduce waits or throttling if needed.

---

## 📄 License

This project is open-source for educational and personal use. Feel free to fork and contribute!
