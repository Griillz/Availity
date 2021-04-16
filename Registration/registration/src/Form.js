import { TextField, Container, Grid, Button } from "@material-ui/core";
import React from "react";
import "./Form.css";

function form() {
  return (
    <div>
      <Container maxWidth="md" className="form-container">
        <Grid
          container
          justify="center"
          alignItems="center"
          direction="column"
          spacing={3}
        >
          <TextField
            label="First Name"
            placeholder="John"
            variant="outlined"
            className="form-field"
            fullWidth
          />
          <TextField
            label="Last Name"
            placeholder="Doe"
            variant="outlined"
            className="form-field"
            fullWidth
          />
          <TextField
            label="NPI Number"
            placeholder="12345"
            variant="outlined"
            className="form-field"
            fullWidth
          />
          <TextField
            label="Business Address"
            placeholder="5555 Gate Pkwy #110"
            variant="outlined"
            className="form-field"
            fullWidth
          />
          <TextField
            label="Telephone Number"
            placeholder="(904) 470-4900"
            variant="outlined"
            className="form-field"
            fullWidth
          />
          <TextField
            label="Email Address"
            placeholder="Anthony.Deangelis@availity.com"
            variant="outlined"
            className="form-field"
            fullWidth
          />
          <Button variant="contained" color="primary" className="form-button">
            Submit
          </Button>
        </Grid>
      </Container>
    </div>
  );
}

export default form;
