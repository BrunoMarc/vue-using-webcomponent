export async function getEstablishment(name) {

    const response = await fetch(`/api/establishment/${name}/info`);
    return await response.json();
}

export async function getSchedules(establishmentId, category, service, payment, agreement) {

    let url = `/api/establishments/${establishmentId}/schedules?payment=${payment}&category=${category}&service=${service}`;
    if (agreement) {
        url = `${url}&agreementId=${agreement}`
    }
    const response = await fetch(url);
    return await response.json();
}