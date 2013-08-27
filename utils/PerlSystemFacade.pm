package PerlSystemFacade;
# import all the pre-existing/legacy Perl Modules you would wish to call here
###############################################
##### Simple methods to test the plumbing #####
###############################################
sub say_hello_psf {
      my $retVal;
      # just return a string
      $retVal = ' hello from PerlSystemFacade.say_hello_psf';
      return $retVal;   
}
sub echo_args_psf {
my ($Refer, $PassData) = @_;
      #create some output with the input
      return {Status => 'Test', EchoData => ${$PassData}{SessionID}, FromIP => ${$PassData}{ClientIP}};
};
################################################
# Facade Methods that use the existing system to produce their result #
################################################
sub say_hello {
      my $retVal;
      # delegate to the legacy method
      use PreExistingMod;
      $retVal = PreExistingMod::say_hello();
      return $retVal; 
}
sub echo_args {
      my ($Refer, $PassData) = @_;
      my $retVal;
      # delegate to the legacy method
      use PreExistingMod;
      $retVal = PreExistingMod::echo_args( ($PassData) );
      return $retVal;   
}
1;  # Perl Modules require this