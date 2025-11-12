package br.edu.ifal.aluno.arestro.model.contact

val contactList = listOf<Contact>(
    Contact(
        userId = 1,
        type = ContactType.EMAIL,
        value = "johndoe@example.com"
    ),
    Contact(
        userId = 1,
        type = ContactType.PHONE,
        value = "+977 9840103828"
    )
)