export async function getAllUsers() {

    const response = await fetch('/api/users');
    return await response.json();
}

export async function createUser(data) {
    const response = await fetch(`/api/user`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
      })
    return await response.json();
}

export async function getEstablishment(name) {

    const response = await fetch(`/api/establishment/${name}/info`);
    return await response.json();
}

export async function getSchedules(establishmentId, category, service, payment) {

    const response = await fetch(`/api/establishments/${establishmentId}/schedules?payment=${payment}&category=${category}&service=${service}`);
    return await response.json();
}