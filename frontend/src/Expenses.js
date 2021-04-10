import React, { Component } from 'react'; 
import AppNav from './AppNav';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import './App.css';
import {Container,Form,Label, FormGroup,Input,Button} from 'reactstrap';

import {Link} from 'react-router-dom';
  

class Expenses extends Component {
    emptyItem = {
        id : '103',
        description : '',
        expensedateInstant : new Date(),
        location : '',
        categories : [4, "grocery"]

    }
    constructor(props) {
        super(props)
        this.state = { 
            date:new Date(),
            isLoading:true,
            expenses:[],
            categories :[],
            items : this.emptyItem
         }
    }
    
     async remove(id){
         await fetch('/api/v1/expenses/${id}' , {
             method : 'DELETE',
             headers :{
                 'Accept' : 'application/json',
                 'Content-Type' : 'application/json'
             }

            }).then(() => {
                let updateExpenses= [...this.state.Expenses].filter(i => i.id!==id);  
                this.setState({Expenses : updateExpenses});          

});  

 }

     
     async componentDidMount(){
         const response= await fetch('/api/v1/categories');
         const body=await response.json();
         this.setState({categories : body}); 

         const responseExp = await fetch('/api/v1/expenses');
         const bodyExp=await responseExp.json();
         this.setState({expenses : body , isLoading : false});
     }
    render() {
        
        const title=<h2>Add Expense</h2>
        const {categories} = this.state;
        const {expenses, isLoading} = this.state;
        

        if(isLoading)
            return (<div>Loading</div>)

        
        let optionList = categories.map(category=>
            <option id={category.id}>
            {category.name}
            </option>
            )

        let rows= 
        Expenses.map( expense =>
            <tr>
                <td>{expense.description}</td>
                <td>{expense.location}</td>
                <td>{expense.expensedate}</td>
                <td>{expense.category.name}</td>
                <td><Button size="5m" color="danger" onClick ={ () => this.remove(expense.id)}>Delete </Button></td>


            </tr>
            )


        return ( 
            <div>
                <AppNav/>
                <Container>
                    {title}
                   <Form onSubmit={this.handleSubmit}>
                       <FormGroup>
                           <Label for ="description">Title</Label>
                           <Input type="description"  name="description" id="description" onChange={this.handleChange} autoComplete="name"/>
                       </FormGroup>
                       <FormGroup>
                           <Label for ='category'>Category</Label>

                           <select>
                               {optionList}
                           </select>
                           <Input type='text' name='category' id='category' onChange={this.handleChange}/>

                       </FormGroup>
                       <FormGroup>
                           <Label for ='expenseDate'>Expense Date</Label>
                           <DatePicker selected={this.state.date} onChange={this.handleChange}/>

                       </FormGroup>
                       <FormGroup>
                           <Label for ='location'>Location</Label>
                           <Input type='text' name='location' id='location' onChange={this.handleChange}/>

                       </FormGroup>
                       <FormGroup>
                           <Button color='primary' type='submit' >Save</Button>{'      '}

                          <Button color='secondary' tag={Link} to="/categories">Cancel</Button>
                           </FormGroup>
                   </Form>
               </Container>

               <Container>
                   <h3>Expenses List</h3>
                   <table className="mt-4">
                        <thead>
                            <tr>
                                <th width="20%">Discription</th>
                                <th width="10%">Location</th>
                                <th >Category</th>
                                <th width="">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {rows}
                        </tbody>
                   </table>
               </Container>
            </div>
         );
    }
}
 
export default Expenses;