function uuid() {
    let qqNumber = '';
    const random = Math.random;

    // Generate the first digit (cannot be 0)
    qqNumber += Math.floor(random() * 9) + 1;

    // Generate the remaining digits
    for (let i = 1; i < 8; i++) {
        qqNumber += Math.floor(random() * 10);
    }

    return qqNumber;
}

module.exports = uuid()
