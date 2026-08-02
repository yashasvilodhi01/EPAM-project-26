// Initial Balance
let balance = 10000;

// Get HTML Elements
const balanceText = document.getElementById("balance");
const amountInput = document.getElementById("amount");
const historyList = document.getElementById("historyList");

// Deposit Function
function depositMoney() {

    let amount = Number(amountInput.value);

    if (amount <= 0 || isNaN(amount)) {
        alert("Please enter a valid amount.");
        return;
    }

    balance += amount;
    balanceText.textContent = balance;

    addHistory("✅ Deposited ₹" + amount);

    amountInput.value = "";
}

// Withdraw Function
function withdrawMoney() {

    let amount = Number(amountInput.value);

    if (amount <= 0 || isNaN(amount)) {
        alert("Please enter a valid amount.");
        return;
    }

    if (amount > balance) {
        alert("Insufficient Balance!");
        return;
    }

    balance -= amount;
    balanceText.textContent = balance;

    addHistory("💸 Withdrawn ₹" + amount);

    amountInput.value = "";
}

// Show Balance
function showBalance() {
    alert("Current Balance: ₹" + balance);
}

// Add Transaction History
function addHistory(message) {

    let li = document.createElement("li");

    let date = new Date();

    li.textContent =
        message +
        " | " +
        date.toLocaleDateString() +
        " " +
        date.toLocaleTimeString();

    historyList.appendChild(li);
}