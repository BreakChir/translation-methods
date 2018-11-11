use List::MoreUtils qw(uniq);

my @links = ();
open(FIL,"data.txt");

$text = "";
while (my $row = <FIL>) {
	$text = $text . $row;
}
$text =~ s/\R/ /g;

while ($text =~ /<\s*a.+?href\s*=\s*("\s*(.*?)\s*"|\s*'(.*?)\s*')(.*?)>/) {
    if ($text =~ /<\s*a(.+?)href\s*=\s*("\s*(.*?)\s*"|\s*'(.*?)\s*')(.*?)>/) {
        $row = $3 . $4;
        print $row . " |\n";
        $row =~ s/<\s*a(.+?)href\s*=\s*"\s*(.*?)\s*"(.*?)>/$2/;
        $row =~ s/<\s*a(.+?)href\s*=\s*'\s*(.*?)\s*'(.*?)>/$2/;
        $row =~ s/^.*?:\/\/(.*?)/$1/;    
        $row =~ s/[:\/#?].*$//;

        if (!(($row =~ /^$/) || ($row =~ /\.\./) || ($row =~ /\.$/) || ($row =~ /^\./))) {
            push @links, $row;
        }
    }
    $text =~ s/<\s*a.*?>//;
}

my @uniq_links = uniq(@links);
my @sorted = sort @uniq_links;

print "|||||||||||||||||||||||||||||||||||||||||||\n";
foreach my $link (@sorted) {
  print $link . "\n";
}