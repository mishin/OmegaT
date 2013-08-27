package PreExistingMod;
# import all the preexisting Perl Modules you would wish to call here
##### a routine with no arguments and a single String output #####
sub say_hello {
 return 'Hello from the PreExistingMod' ;
}
##### a Perl routine with an array of arguments #####
##### and a hash for output                     #####
sub echo_args {
my ($PassData) = @_;
      return { Status => 'Test', 
               EchoData => ${$PassData}{SessionID}, 
               FromIP => ${$PassData}{ClientIP}  };
};
###############################################
1;  # Perl Modules require this  