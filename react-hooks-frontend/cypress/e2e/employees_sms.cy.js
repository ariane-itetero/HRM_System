describe('empty spec', () => {
  it('visit page', () => {
    cy.visit('/')
    cy.get('tr:nth-child(4) > td:nth-child(2)').click();
cy.get('.form-group:nth-child(1) > .form-control').click();
cy.get('.form-group:nth-child(1) > .form-control').type('Kenny');
cy.get('.form-group:nth-child(2) > .form-control').click();
cy.get('.form-group:nth-child(2) > .form-control').type('{backspace}');
cy.get('.form-group:nth-child(2) > .form-control').type('Imanzi');
cy.get('.form-group:nth-child(3) > .form-control').click();
cy.get('.form-group:nth-child(3) > .form-control').type('{backspace}');
cy.get('.form-group:nth-child(3) > .form-control').type('kenny@gmail.com');
cy.get('.btn-success').click();
  })
  describe('Form', () => {
    beforeEach(() => {
      cy.visit('/')
    })
  


  })

})